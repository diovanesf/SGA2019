import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Table, Thead, Tbody, Tr, Th, Td } from "react-super-responsive-table";

import "react-super-responsive-table/dist/SuperResponsiveTableStyle.css";
import "./index.css";

import api from "../../services/api";

export default function Dashboard({ history }) {
  const [solicitacoes, setSolicitacoes] = useState([]);

  //Pega as solicitacoes utilizando o verbo get do http
  useEffect(() => {
    api.get("/solicitacoes").then(response => setSolicitacoes(response.data));
  }, [solicitacoes]);

  function handleSubmitToDelete(solicitacaoId) {
    async function deletarSolicitacao() {
      var userChoice = window.confirm(
        "Você deseja mesmo deletar esta solicitação?"
      );
      if (userChoice) {
        const response = await api.delete("/solicitacoes/" + solicitacaoId);

        if (response.status === 204) {
          const response = await api.get("/solicitacoes");
          setSolicitacoes(response.data);
        } else {
          alert("Ocorreu algum erro ao tentar excluir, tente novamente.");
        }
      }
    }

    deletarSolicitacao();
  }

  return (
    <>
      <Link to="/solicitar">
        <button className="btn btn-new-solicitacao">Nova Solicitação</button>
      </Link>

      <Link to="/visualizar">
        <button className="btn btn-new-solicitacao">Visualizar Solicitações</button>
      </Link>

    
    
      
    </>
  );
}
