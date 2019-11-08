import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
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
  const [nomeResponsavel, setNomeResponsavel] = useState("");
  const [localAtividade, setLocalAtividade] = useState("");
  const [periodoAtividadeInicio, setPeriodoAtividadeInicio] = useState("");
  const [periodoAtividadeFinal, setPeriodoAtividadeFinal] = useState("");
  const [cargaHorariaAtividade, setCargaHorariaAtividade] = useState("");
  const [cargaHorariaSolicitada, setCargaHorariaSolicitada] = useState("");
  const [descricaoAtividade, setDescricaoAtividade] = useState("");
  const [data] = useState("");
  const [documentosEnv, setDocumentosEnv] = useState([]);

  useEffect(() => {
    api.get("grupos").then(response => {
      setGrupos(response.data);
    });
  }, []);
  useEffect(() => {
    api.get("atividades").then(response => {
      setAtividades(response.data);
    });
  }, [grupos, grupo]);

  const setarDocumentos = event => {
    setAtividade(event.target.value);
    setDocumentos(event.target.value.docsNecessarios.split(","));
    console.log(atividade);
    console.log(documentos);
  };

  async function handleSubmit(event) {
    event.preventDefault();
    console.log(solicitante);

    try {
      await api.post("/solicitacao", {
        solicitante,
        matricula,
        grupo,
        atividade,
        nomeResponsavel,
        localAtividade,
        periodoAtividadeInicio,
        periodoAtividadeFinal,
        cargaHorariaAtividade,
        cargaHorariaSolicitada,
        descricaoAtividade,
        data,
        documentosEnv
      });
      history.push("/");
    } catch (e) {
      alert(
        "Um erro na solicitação, verifique os dados informados e tente novamente!"
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
        <label htmlFor="solicitante">Solicitante *</label>
        <input
          id="solicitante"
          name="nolicitanteome"
          type="text"
          placeholder="Solicitante"
          value={solicitante}
          required
          onChange={event => setSolicitante(event.target.value)}
        />

        <label htmlFor="matricula">Matrícula *</label>
        <input
          id="matricula"
          name="matricula"
          type="number"
          placeholder="Matricula"
          value={matricula}
          required
          onChange={event => setMatricula(event.target.value)}
        />

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
          <option selected disabled>
            Selecione um grupo
          </option>
          {_.map(grupos, (grupo, index) => {
            return <option value={grupo.id}>{grupo.nome}</option>;
          })}
        </select>

        <label htmlFor="atividade">Atividade *</label>
        <select
          id="atividade"
          name="atividade"
          // required
          value={atividade}
          onChange={setarDocumentos}
        >
          <option selected disabled>
            Selecione uma atividade
          </option>
          {_.map(atividades, (atividade, index) => {
            return <option value={atividade.id}>{atividade.nome}</option>;
          })}
        </select>

        <label htmlFor="localAtividade">Local da Atividade *</label>
        <input
          id="localAtividade"
          name="localAtividade"
          type="text"
          placeholder="Local da Atividade"
          value={localAtividade}
          required
          onChange={event => setLocalAtividade(event.target.value)}
        />

        <label htmlFor="periodoAtividadeInicio">Período da atividade *</label>
        <input
          id="periodoAtividadeInicio"
          name="periodoAtividadeInicio"
          type="date"
          placeholder="Período da atividade inicio"
          value={periodoAtividadeInicio}
          required
          onChange={event => setPeriodoAtividadeInicio(event.target.value)}
        />
        <label htmlFor="periodoAtividadeInicio">Até</label>
        <input
          id="periodoAtividadeFinal"
          name="periodoAtividadeFinal"
          type="date"
          placeholder="Período da atividade final"
          value={periodoAtividadeFinal}
          required
          onChange={event => setPeriodoAtividadeFinal(event.target.value)}
        />

        <label htmlFor="cargaHorariaAtividade">
          Carga-horária da atividade *
        </label>
        <input
          id="cargaHorariaAtividade"
          name="cargaHorariaAtividade"
          type="number"
          placeholder="Carga-horária da atividade"
          value={cargaHorariaAtividade}
          required
          onChange={event => setCargaHorariaAtividade(event.target.value)}
        />

        <label htmlFor="cargaHorariaSolicitada">
          Carga-horária solicitada *
        </label>
        <input
          id="cargaHorariaSolicitada"
          name="cargaHorariaSolicitada"
          type="number"
          placeholder="Carga-horária solicitada"
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
          return (
            <input
              id={documento.nome}
              name={documento.nome}
              type="file"
              placeholder="Comprovante"
              value={documento}
              required
              onChange={event => setDocumentosEnv(event.target.value)}
            />
          );
        })}

        <button type="submit" className="btn btn-add">
          Solicitar
        </button>
      </form>
      <Link to="/">
        <button className="btn btn-add">
          <a
            href="/"
            style={{
              textDecoration: "none",
              color: "white"
            }}
          >
            Voltar
          </a>
        </button>
      </Link>
    </>
  );
}