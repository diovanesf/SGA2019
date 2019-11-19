import React, { useState, useEffect } from 'react'
import { Button, Table, Row, Col, Form } from 'react-bootstrap'
import { IoIosCloseCircleOutline, IoMdSave } from 'react-icons/io'
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
export function AvaliarAcg() {
	const [redirectTo, setRedirectTo] = useState()
	const [formValidado, setFormValidado] = useState()
	const [solicitacao, setSolicitacao] = useState({ atividade: { grupo: {} }, anexos: {} })

	const [deferido, setDeferimento] = useState()
	const [cargaHorariaAprov, setCargaHorariaAprov] = useState()
	const [obs, setObs] = useState()

	console.log('solicitacao', solicitacao)
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

	function _handleSubmit(e) {
		setFormValidado(true)
		e.preventDefault()
		console.log('deferimento', deferido )
		if (deferido !== 'indef' && deferido !== 'def') {
			alert('Você deve selecionar uma situação para a solicitação')
			return
		}
		console.log('cargaHorariaAprov', cargaHorariaAprov )
		if(deferido==='def' && (cargaHorariaAprov==null || cargaHorariaAprov <= 0)){
			alert('Você deve aprovar uma carga horária maior que 0')
			return
		}
		if(deferido==='indef' && (obs==null || obs === '')){
			alert('Você deve informar o motivo do indeferimento')
			return
		}
		let data = {
			deferido:deferido==='def',
			cargaHorariaAtribuida:cargaHorariaAprov,
			parecer:obs
		}

		api.post(`avaliacao/${id}`, data)
			.then((r) => {
				console.log(r)
				alert('Avaliação Feita com Sucesso')
				setRedirectTo('/')
			})
			.catch((e) => {
				console.log(e)
				console.log(e.response)
				alert('Algo de errado ocorreu ao avaliar')
			})
	}
	return (
		<>
			{renderRedirect()}
			<Form onSubmit={_handleSubmit} validated={formValidado} noValidate>
				<Row>
					<Col md={8} xs={12}>
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
														variant='outline-secondary'
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
							</tbody>
							<tbody>
								<tr>
									<td colSpan={100} style={{ background: '#0002', borderTop: '2px #0008 solid' }}>
										Área do coordenador
									</td>
								</tr>
								<tr>
									<td>Situação*</td>
									<td>
										<Form.Control
											value={deferido}
											as='select'
											onChange={(e) => setDeferimento(e.target.value)}
											required
										>
											<option value='' selected disabled>
												Selecione uma opção
											</option>
											<option value='def'>Deferida</option>
											<option value='indef'>Indeferida</option>
										</Form.Control>
									</td>
								</tr>
								{deferido === 'def' ? (
									<>
										<tr>
											<td>Carga Horária Aprovada*</td>
											<td>
												<Form.Control
													required
													value={cargaHorariaAprov}
													type='number'
													min='1'
													onChange={(e) =>
														setCargaHorariaAprov(
															e.target.value.replace(/\D/g, '').slice(0, 5)
														)
													}
												/>
											</td>
										</tr>
										<tr>
											<td>Observações</td>
											<td>
												<Form.Control value={obs} onChange={(e) => setObs(e.target.value)} />
											</td>
										</tr>
									</>
								) : null}
								{deferido === 'indef' ? (
									<>
										<tr>
											<td>Observações*</td>
											<td>
												<Form.Control
													required
													as='textarea'
													value={obs}
													onChange={(e) => setObs(e.target.value)}
												/>
											</td>
										</tr>
									</>
								) : null}
							</tbody>
						</Table>

						<div className='d-flex justify-content-end'>
							<Button
								variant='outline-danger'
								className='py-0 px-1'
								onClick={() => {
									if (window.confirm('Deseja mesmo cancelar')) setRedirectTo('/')
								}}
							>
								<IoIosCloseCircleOutline />
							</Button>
							<Button type={'submit'} variant='outline-success' className='ml-3 py-0 px-1'>
								<IoMdSave />
							</Button>
						</div>
					</Col>
				</Row>
			</Form>
		</>
	)
}
