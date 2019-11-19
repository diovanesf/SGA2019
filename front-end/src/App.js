import React from 'react'
import './App.css'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import { Page } from './components'
import 'bootstrap/dist/css/bootstrap.min.css'
import { ListaDeAcgs } from './screens/ListaDeAcgs'
import { SolicitarAcg } from './screens/SolicitarAcg'
import { AvaliarAcg } from './screens/AvaliarAcg'
import { InfosAcg } from './screens/InfosAcg'

function App() {
	return (
		<BrowserRouter>
			<Page>
				<Switch>
        <Route exact path='/' component={ListaDeAcgs} />
        <Route exact path='/solicitar' component={SolicitarAcg} />
        <Route exact path='/avaliar/:id' component={AvaliarAcg} />
        <Route exact path='/infos/:id' component={InfosAcg} />
					{/*
					<Route path='/editar/:id' component={EditarFuncionario} />
  <Route component={Pagina404} /> */}
				</Switch>
			</Page>
		</BrowserRouter>
	)
}

export default App
