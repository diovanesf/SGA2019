import React, { useState, useEffect } from 'react'
import { Button, Table, Row, Col, Form } from 'react-bootstrap'
import { IoIosCloseCircleOutline, IoMdSave } from 'react-icons/io'
import { Redirect } from 'react-router-dom'
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
export function SolicitarAcg() {
	const [redirectTo, setRedirectTo] = useState()
	const [grupos, setGrupos] = useState()
	const [atividades, setAtividades] = useState()
	const [formValidado, setFormValidado] = useState()
	const [documentosEnv, setDocumentosEnv] = useState({})
	console.log('docs', documentosEnv)
	const [grupo, setGrupo] = useState()
	const [atividadeIndex, setAtividadeIndex] = useState()
	const [atividadeObj, setAtividadeObj] = useState({})

	const [matricula, setMatricula] = useState()
	const [aluno, setAluno] = useState()
	const [local, setLocal] = useState()
	const [dataInicio, setDataInicio] = useState()
	const [dataFim, setDataFim] = useState()
	const [cargaHorariaReali, setCargaHorariaReali] = useState()
	const [cargaHorariaSoli, setCargaHorariaSoli] = useState()
	const [profRes, setProfRes] = useState()
	const [descricao, setDescricao] = useState()

	useEffect(() => {
		api.get('grupos')
			.then((r) => {
				console.log(r)
				
				setGrupos(r.data)
			})
			.catch((e) => {
				console.log(e)
				alert('Erro ao buscar os grupos. Atualize a pagina para tentar novamente')
			})
	}, [])
	useEffect(() => {
		setAtividadeIndex()
		setAtividadeObj({})
		api.get(`atividades/porGrupo/${grupo}`)
			.then((r) => {
				console.log(r)
				setAtividades(r.data)
				console.log(r.data[0])
			})
			.catch((e) => {
				console.log(e)
				grupo && alert('Erro ao buscar as atividades. Atualize a pagina para tentar novamente')

			})
	}, [grupo])

	function renderRedirect() {
		if (redirectTo) {
			return <Redirect to={redirectTo} />
		}
	}

	function addDoc(event, nomeArquivo) {
		console.log(event.target.id, nomeArquivo)
		if (!event || !event.target || !event.target.files || event.target.files.length === 0) {
			return
		}

		const name = event.target.files[0].name
		const lastDot = name.lastIndexOf('.')
		const ext = name.substring(lastDot + 1).toLowerCase()

		if (ext !== 'pdf' && ext !== 'jpg' && ext !== 'jpeg' && ext !== 'png' && ext !== 'zip') {
			const arquivoTemp = Object.keys(documentosEnv).reduce((object, key) => {
				if (key !== nomeArquivo) {
					console.log('not deleting', key, nomeArquivo)
					object[key] = documentosEnv[key]
				}
				return object
			}, {})
			console.log(arquivoTemp)
			setDocumentosEnv(arquivoTemp)

			alert('Tipo de arquivo não permitido')
			event.target.value = ''
			return
		}
		if (_.size(documentosEnv) === 0) {
			const fileData = {}
			fileData[nomeArquivo] = {
				idDoc: event.target.id,
				file: event.target.files[0],
			}
			setDocumentosEnv({ ...documentosEnv, ...fileData })
			return
		} else {
			let index
			for (index = 0; index < documentosEnv.length; index++) {
				if (documentosEnv[index].idDoc === event.target.id) {
					documentosEnv[index].file = event.target.files[0]
					return
				}
			}
			const fileData = {}
			fileData[nomeArquivo] = {
				idDoc: event.target.id,
				file: event.target.files[0],
			}
			setDocumentosEnv({ ...documentosEnv, ...fileData })
		}
		console.log(documentosEnv)
	}

	function _handleSubmit(e) {
		setFormValidado(true)
		e.preventDefault()
		if (
			!matricula ||
			!aluno ||
			!local ||
			!dataInicio ||
			!dataFim ||
			!cargaHorariaSoli ||
			!profRes ||
			!descricao ||
			!atividadeObj.idAtividade ||
			_.size(documentosEnv) !== _.size(atividadeObj.docs)
		) {
			alert('Algum campo ficou em branco ou não está preenchido corretamente')
			return
		}

		let data = {
			matricula,
			aluno,
			local,
			dataInicio,
			dataFim,
			cargaHorariaSoli,
			profRes,
			descricao,
			idAtividade: atividadeObj.idAtividade,
		}

		const formData = new FormData()
		_.forEach(data, (value, index) => {
			formData.append(index, value)
		})
		_.forEach(documentosEnv, (value) => {
			formData.append('anexo', value.file)
		})
		for (var pair of formData.entries()) {
			console.log('form', pair[0], pair[1])
		}
		api.post(`solicitacao/`, formData)
			.then((r) => {
				console.log(r)
				alert('Solicitacao Feita com Sucesso')
				setRedirectTo('/')
			})
			.catch((e) => {
				console.log(e.response)
				alert('Algo de errado ocorreu ao solicitar')
			})
	}
	return (
		<>
			{renderRedirect()}
			<Form onSubmit={_handleSubmit} validated={formValidado} noValidate>
				<Row>
					<Col md={8} xs={12}>
						<Table className='mt-3' hover responsive>
							<tbody>
								<tr>
									<td>Matricula</td>
									<td>
										<Form.Control
											required
											value={matricula}
											onChange={(e) => setMatricula(e.target.value.replace(/\D/g, ''))}
										/>
									</td>
								</tr>
								<tr>
									<td>Aluno</td>
									<td>
										<Form.Control
											required
											value={aluno}
											onChange={(e) => setAluno(e.target.value)}
										/>
									</td>
								</tr>
								<tr>
									<td>Grupo</td>
									<td>
										<Form.Control
											required
											as='select'
											value={grupo}
											onChange={(e) => setGrupo(e.target.value)}
										>
											<option value={''} selected disabled>
												Seleciona um Grupo
											</option>
											{_.map(grupos, (value, index) => {
												return <option value={value.idGrupo}>{value.nome}</option>
											})}
										</Form.Control>
									</td>
								</tr>
								<tr>
									<td>Atividade</td>
									<td>
										<Form.Control
											required
											as='select'
											value={atividadeIndex}
											onChange={(e) => {
												const index = e.target.value
												setAtividadeIndex(index)
												setAtividadeObj(atividades[index])
											}}
										>
											<option value={''} selected={!atividadeIndex} disabled>
												Seleciona um Grupo
											</option>
											{_.map(atividades, (value, index) => {
												return <option value={index}>{value.descricao}</option>
											})}
										</Form.Control>
									</td>
								</tr>

								<tr>
									<td>Local</td>
									<td>
										<Form.Control
											required
											value={local}
											onChange={(e) => setLocal(e.target.value)}
										/>
									</td>
								</tr>
								<tr>
									<td>Data de Início</td>
									<td>
										<Form.Control
											required
											type='date'
											max={new Date().toJSON().split('T')[0]}
											value={dataInicio}
											onChange={(e) => setDataInicio(e.target.value)}
										/>
									</td>
								</tr>
								<tr>
									<td>Data de Fim</td>
									<td>
										<Form.Control
											required
											type='date'
											min={dataInicio}
											max={new Date().toJSON().split('T')[0]}
											value={dataFim}
											onChange={(e) => setDataFim(e.target.value)}
										/>
									</td>
								</tr>
								<tr>
									<td>Carga Horária Realizada</td>
									<td>
										<Form.Control
											required
											type='number'
											value={cargaHorariaReali}
											onChange={(e) => setCargaHorariaReali(e.target.value.replace(/\D/g, ''))}
										/>
									</td>
								</tr>
								<tr>
									<td>Carga Horária Soliciada</td>
									<td>
										<Form.Control
											required
											type='number'
											value={cargaHorariaSoli}
											onChange={(e) => setCargaHorariaSoli(e.target.value.replace(/\D/g, ''))}
										/>
									</td>
								</tr>
								<tr>
									<td>Professor Responsável</td>
									<td>
										<Form.Control
											required
											value={profRes}
											onChange={(e) => setProfRes(e.target.value)}
										/>
									</td>
								</tr>
								<tr>
									<td>Descrição da atividade</td>
									<td>
										<Form.Control
											required
											as='textarea'
											value={descricao}
											onChange={(e) => setDescricao(e.target.value)}
										/>
									</td>
								</tr>
								{_.map(atividadeObj.docs, (documento, index) => {
									return (
										<tr>
											<td>{documento.nome}</td>
											<td>
												<div>
													<input
														required
														id={documento.idDocNecessario}
														name={documento.nome}
														type='file'
														style={{
															backgroundColor: formValidado
																? documentosEnv[documento.nome]
																	? '	#2da446'
																	: '#dc3546'
																: '#0000',
														}}
														placeholder='Comprovante'
														onChange={(event) => {
															addDoc(event, documento.nome)
														}}
													/>
												</div>
											</td>
										</tr>
									)
								})}
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
