import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom"
import api from "../../services/api";
import _ from "lodash";

export default function Solicitar({ history }) {
  // listas de grupos e atividades
  const [grupos, setGrupos] = useState([]);
  const [atividades, setAtividades] = useState([]);
  const [documentos, setDocumentos] = useState([]);

  // dados para criar a solicitação
  const [solicitante, setSolicitante] = useState("");
  const [matricula, setMatricula] = useState("");
  const [grupo, setGrupo] = useState("");
  const [atividade, setAtividade] = useState("");
  const [professorResponsavel, setProfessorResponsavel] = useState("");
  const [dataInicioAtividade, setDataInicioAtividade] = useState("");
  const [dataFimAtividade, setDataFimAtividade] = useState("");
  const [cargaHorariaAproveitada, setCargaHorariaAproveitada] = useState("");
  const [cargaHorariaSolicitada, setCargaHorariaSolicitada] = useState("");
  const [descricaoAtividade, setDescricaoAtividade] = useState("");
  const [curriculo, setCurriculo] = useState("");
  const [dataSolicitacao] = useState("")

  useEffect(() => {
    api.get("/buscarGrupos/").then(response => {
      setGrupos(response.data);
    }).catch(e=>console.log("error", e.response));
  }, []);
  useEffect(() => {
    api.get("/buscarAtividades/").then(response => {
      setAtividades(response.data);
    });
  }, [grupos, grupo]);

  const setarDocumentos = event => {
    setAtividade(event.target.value);
    setDocumentos(event.target.value.docsNecessarios.split(','))
    console.log(atividade)
    console.log(documentos)
  }

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(solicitante)

    try {
      await api.post("/solicitacao", {
        solicitante,
        matricula,
        grupo,
        atividade,
        professorResponsavel,
        dataInicioAtividade,
        dataFimAtividade,
        cargaHorariaAproveitada,
        cargaHorariaSolicitada,
        descricaoAtividade,
        curriculo,
        dataSolicitacao
      });
      history.push("/");
    } catch (e) {
      alert(
        "Erro na solicitação! Verifique os seus dados e tente novamente."
      );
    }
  }

  return (
    <>
      <p>
        Efetue aqui sua solicitação para aproveitamento de{" "}
        <strong>ACG's</strong>.
      </p>

      <form onSubmit={handleSubmit}>
        <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-between' }}>
          <div style={{ display: 'flex', flexDirection: 'column', width: '45%' }}>

            <label htmlFor="nome">Nome *</label>
            <input
              id="solicitante"
              name="solicitante"
              type="text"
              placeholder="Solicitante"
              value={solicitante}
              required
              onChange={event => setSolicitante(event.target.value)}
              style={{
                color: "white"
              }}
            />
          </div>

          

          <div style={{ display: 'flex', flexDirection: 'column', width: '45%' }}>

            <label htmlFor="matricula">Matrícula *</label>
            <input
              id="matricula"
              name="matricula"
              type="text"
              placeholder="Matricula"
              value={matricula}
              required
              onChange={event => setMatricula(event.target.value)}
              style={{
                color: "black"
              }}
            />
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', width: '45%' }}>
          <label htmlFor="curriculo">Currículo *</label>
        <select
          id="curriculo"
          name="curriculo"
          // required
          value={curriculo}
          
        >
          <option value="" disabled>
            Selecione um currículo
          </option>
           <option value='2010'>2010</option>;
           <option value='2010'>2018</option>;
        </select>
        </div>
        </div>

        <label htmlFor="grupo">Grupo *</label>
        <select
          id="grupo"
          name="grupo"
          value={grupo}
          // required
          onChange={e => {
            setGrupo(e.target.value);
          }}
        >
          <option disabled value=''>
            Selecione um grupo
          </option>
          {_.map(grupos, (grupo, index) => {
            return <option value={grupo.id}>{grupo.nomeGrupo}</option>;
          })}
        </select>

        <label htmlFor="atividade">Atividade *</label>
        <select
          id="atividade"
          name="atividade"
          // required
          value={atividade}
          onChange={
            setarDocumentos
          }
        >
          <option value="" disabled>
            Selecione uma atividade
          </option>
          {_.map(atividades, (atividade, index) => {
            return <option value={atividade.id}>{atividade.nomeAtividade}</option>;
          })}
        </select>

        <label htmlFor="professorResponsavel">Professor(a) responsável *</label>
        <input
          id="professorResponsavel"
          name="professorResponsavel"
          type="text"
          placeholder="Professor(a) responsável"
          value={professorResponsavel}
          required
          onChange={event => setProfessorResponsavel(event.target.value)}
        />

        <label htmlFor="dataInicioAtividade">Período da atividade *</label>
        <input
          id="dataInicioAtividade"
          name="dataInicioAtividade"
          type="date"
          placeholder="Período da atividade inicio"
          value={dataInicioAtividade}
          required
          onChange={event => setDataInicioAtividade(event.target.value)}
        />
        <label htmlFor="dataInicioAtividade">Até</label>
        <input
          id="dataFimAtividade"
          name="dataFimAtividade"
          type="date"
          placeholder="Data final da atividade"
          value={dataFimAtividade}
          required
          onChange={event => setDataFimAtividade(event.target.value)}
        />

        <label htmlFor="cargaHorariaAproveitada">
          Carga-horária da atividade *
        </label>
        <input
          id="cargaHorariaAproveitada"
          name="cargaHorariaAproveitada"
          type="number"
          placeholder="Carga horária a ser aproveitada"
          value={cargaHorariaAproveitada}
          required
          onChange={event => setCargaHorariaAproveitada(event.target.value)}
        />

        <label htmlFor="cargaHorariaSolicitada">
          Carga-horária solicitada *
        </label>
        <input
          id="cargaHorariaSolicitada"
          name="cargaHorariaSolicitada"
          type="number"
          placeholder="Carga horária a ser solicitada"
          value={cargaHorariaSolicitada}
          required
          onChange={event => setCargaHorariaSolicitada(event.target.value)}
        />

        <label htmlFor="descricaoAtividade">Descrição da atividade *</label>
        <input
          id="descricaoAtividade"
          name="descricaoAtividade"
          type="text"
          placeholder="Descrição da atividade"
          value={descricaoAtividade}
          required
          onChange={event => setDescricaoAtividade(event.target.value)}
        />

        <label htmlFor="documento">Comprovante *</label>
        {_.map(documentos, (documento, index) => {
       
        })}


        <button type="submit" className="btn btn-aadd">
          Solicitar
        </button>

      </form>
      <Link to="/">
        <button className="btn btn-aadd"  >
          Voltar
        </button>
      </Link>
    </>
  );
}
