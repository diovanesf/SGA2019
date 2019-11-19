import React, { useState, useEffect } from 'react'
import { Button, Table, Row, Col, Form } from 'react-bootstrap'
import { IoIosCloseCircleOutline, IoMdArrowRoundBack } from 'react-icons/io'
import { Redirect, useParams } from 'react-router-dom'
import _ from 'lodash'
import api from '../services/api'
/*interface Solicitacao {
	
	private long matricula;
	private String aluno;
	private String local;
	private String dataInicio;
	private String dataFim;
	private long cargaHorariaSoli;
	private String profRes;
	private String descricao;
	private long idAtividade;
}*/
export function InfosAcg() {
	const [redirectTo, setRedirectTo] = useState()
	const [formValidado, setFormValidado] = useState()
	const [solicitacao, setSolicitacao] = useState({ atividade: { grupo: {} }, anexos: {} })

	const { id } = useParams('id')
	console.log('id', id)

	useEffect(() => {
		api.get(`solicitacao/busca/${id}`)
			.then((r) => {
				console.log(r)
				setSolicitacao(r.data)
			})
			.catch((e) => {
				console.log(e)
				alert('n foi')
			})
	}, [id])

	function renderRedirect() {
		if (redirectTo) {
			return <Redirect to={redirectTo} />
		}
	}

	return (
		<>
			{renderRedirect()}
			<Row>
				<Col md={8} xs={12}>
					<Button
						variant='outline-success'
						className='py-0 px-1'
						onClick={() => {
							setRedirectTo('/')
						}}
					>
						<IoMdArrowRoundBack />
					</Button>
					<Table hover className='mt-3' responsive>
						<tbody>
							<tr>
								<td>Matricula</td>
								<td>{solicitacao.matricula}</td>
							</tr>
							<tr>
								<td>Aluno</td>
								<td>{solicitacao.nomeAluno}</td>
							</tr>
							<tr>
								<td>Grupo</td>
								<td>{solicitacao.atividade.grupo.nome}</td>
							</tr>
							<tr>
								<td>Atividade</td>
								<td>{solicitacao.atividade.descricao}</td>
							</tr>

							<tr>
								<td>Local</td>
								<td>{solicitacao.local}</td>
							</tr>
							<tr>
								<td>Data de Início</td>
								<td>{new Date(solicitacao.dataInicio).toLocaleDateString('pt-BR')}</td>
							</tr>
							<tr>
								<td>Data de Fim</td>
								<td>{new Date(solicitacao.dataFim).toLocaleDateString('pt-BR')}</td>
							</tr>
							<tr>
								<td>Carga Horária Soliciada</td>
								<td>{solicitacao.cargaHorariaSoli}</td>
							</tr>
							<tr>
								<td>Professor Responsável</td>
								<td>{solicitacao.profRed}</td>
							</tr>
							<tr>
								<td>Descrição da atividade</td>
								<td>{solicitacao.descricao}</td>
							</tr>
							{_.map(solicitacao.anexos, (documento, index) => {
								return (
									<tr>
										<td>{documento.doc.nome}</td>
										<td>
											<div>
												<Button
													className='fontSmall'
													variant='outline-info'
													onClick={() => {
														window.open(
															`http://localhost:8888/anexos/${documento.nome}`,
															'_blank',
															'noopener'
														)
													}}
												>
													{documento.nome}
												</Button>
											</div>
										</td>
									</tr>
								)
							})}
							<tr>
								<td>Status</td>
								<td>{solicitacao.status}</td>
							</tr>
							{solicitacao.avaliacao ? (
								<>
									<tr>
										<td>Carga Horária Aprovada</td>
										<td>{solicitacao.avaliacao.cargaHorariaAtribuida}</td>
									</tr>
									<tr>
										<td>Observações</td>
										<td>{solicitacao.avaliacao.justificativa || 'N/A'}</td>
									</tr>
								</>
							) : null}
						</tbody>
					</Table>

					<Button
						variant='outline-success'
						className='py-0 px-1'
						onClick={() => {
							setRedirectTo('/')
						}}
					>
						<IoMdArrowRoundBack />
					</Button>
				</Col>
			</Row>
		</>
	)
}
