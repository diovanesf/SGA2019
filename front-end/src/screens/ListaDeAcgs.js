import React, { useState, useEffect } from 'react'
import { Button, Table } from 'react-bootstrap'
import { IoIosAddCircleOutline, IoIosTrash } from 'react-icons/io'
import { TiDocumentAdd, TiDocumentDelete, TiEyeOutline } from 'react-icons/ti'
import { Redirect } from 'react-router-dom'
import _ from 'lodash'
import api from '../services/api'
export function ListaDeAcgs() {
	const [redirectTo, setRedirectTo] = useState()

	const [solicitacoes, setSolicitacoes] = useState()

	function fetchSolicitacoes() {
		api.get('solicitacao/listar')
			.then((r) => {
				console.log(r)
				setSolicitacoes(r.data)
			})
			.catch((e) => {
				console.log(e)
				console.log(e.response)
				alert('Ocorreu algum erro ao buscar as solicitações')
			})
	}

	useEffect(() => {
		fetchSolicitacoes()
	}, [])

	function renderRedirect() {
		if (redirectTo) {
			return <Redirect to={redirectTo} />
		}
	}
	function _handleDeleteSolicitacao(id) {
		if (window.confirm('Deseja mesmo deletar essa solicitação?'))
			api.delete(`solicitacao/deleta/${id}`)
				.then((r) => {
					console.log(r.data)
					fetchSolicitacoes()
					alert('Solicitação deletada com sucesso')
				})
				.catch((e) => {
					console.log(e)
					console.log(e.response)
					fetchSolicitacoes()
					alert('Ocorreu algum erro ao deletar a solicitação')
				})
	}
	function _handleDeleteAvaliacao(id) {
		if (window.confirm('Deseja mesmo deletar essa avaliação?'))
			api.delete(`avaliacao/${id}`)
				.then((r) => {
					console.log(r.data)
					fetchSolicitacoes()
					alert('Avaliação deletada com sucesso')
				})
				.catch((e) => {
					console.log(e)
					console.log(e.response)
					fetchSolicitacoes()
					alert('Ocorreu algum erro ao deletar a avaliação')
				})
	}

	return (
		<>
			{renderRedirect()}

			<Table className='mt-3' responsive hover>
				<thead>
					<tr>
						<th>Matricula</th>
						<th>Atividade</th>
						<th style={{ whiteSpace: 'nowrap' }}>Data Solicitação</th>
						<th>Status</th>
						<th style={{ width: 130, minWidth: 130 }}>Ações</th>
						<th style={{ width: 40, minWidth: 40 }}>
							<Button
								title="Solicitar"
								variant='outline-success'
								className='py-0 px-1'
								onClick={() => setRedirectTo('/solicitar')}
							>
								<IoIosAddCircleOutline />
							</Button>
						</th>
					</tr>
				</thead>
				<tbody>
					{_.map(solicitacoes, (value, index) => {
						return (
							<tr>
								<td>{value.matricula}</td>
								<td>{value.atividade.descricao}</td>
								<td>{new Date(value.dataAtual).toLocaleDateString('pt-BR')}</td>
								<td>{value.status}</td>
								<td colSpan={2}>
									<div className='d-flex flex-row justify-content-space-around'></div>
									{value.avaliacao == null ? (
										<Button
											title='Avaliar'
											className='mr-1 px-1 py-0'
											variant='outline-primary'
											onClick={() => setRedirectTo(`/avaliar/${value.idSolicitacao}`)}
										>
											<TiDocumentAdd />
										</Button>
									) : (
										<Button
											title='Deletar Avaliação'
											className='mr-1 px-1 py-0'
											variant='outline-danger'
											onClick={() => {
												_handleDeleteAvaliacao(value.avaliacao.idAvaliacao)
											}}
										>
											<TiDocumentDelete />
										</Button>
									)}
									<Button
										disabled={value.avaliacao != null}
										title='Deletar Solicitação'
										className='mr-1 px-1 py-0'
										variant='outline-danger'
										onClick={() => {
											if (value.avaliacao == null) _handleDeleteSolicitacao(value.idSolicitacao)
										}}
									>
										<IoIosTrash />
									</Button>
									<Button 
									onClick={() => setRedirectTo(`/infos/${value.idSolicitacao}`)}
									title='Informações' className='mr-1 px-1 py-0' variant='outline-info'>
										<TiEyeOutline />
									</Button>
								</td>
							</tr>
						)
					})}
				</tbody>
			</Table>
		</>
	)
}
