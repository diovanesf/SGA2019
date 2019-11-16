import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Table, Thead, Tbody, Tr, Th, Td } from "react-super-responsive-table";

import "react-super-responsive-table/dist/SuperResponsiveTableStyle.css";
import "./index.css";

import apiConsulta from "../../services/apiConsulta";

export default function Dashboard({ history }) {
  const [visualizar, setVisualizar] = useState([]);
  return (
  <>

      <Table className="example">
        <Thead>
          <Tr>
            <Th>Nome</Th>
            <Th>Matricula</Th>
            <Th>Grupo</Th>
            <Th>Atividade</Th>
            <Th>Data</Th>
          </Tr>
        </Thead>
        <Tbody>
          {visualizar.map(visualizar => (
            <Tr key={visualizar.id}>
              <Td>{visualizar.nome}</Td>
              <Td>{visualizar.matricula}</Td>
              <Td>{visualizar.grupo}</Td>
              <Td>{visualizar.atividade}</Td>
              <Td>
                <Link to={"/consultar"}>
                  <button
                    type="button"
                    //onClick={() =>
                    //  localStorage.setItem("solicitacaoId", solicitacao.id)
                   // }
                    className="btn-edit"
                  >
                    <i className="fa fa-pencil-square-o" hidden="true"></i>
                  </button>
                </Link>
                
                <button
                  type="button"
                  //onClick={() => handleSubmitToDelete(solicitacao.id)}
                  className="btn-delete"
                >
                  <i className="fa fa-trash" aria-hidden="true"></i>
                 
      <Link to="/">
        <button className="btn btn-add" >
          Voltar
        </button>
      </Link>
                </button>
     
                   </Td>
            </Tr>
          ))}
        </Tbody>
      </Table>
    </>
    
  );
};
