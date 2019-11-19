import { Navbar } from 'react-bootstrap'
import React from 'react'
export function Header() {
	return (
		<Navbar variant="dark" className="p-0 d-flex justify-content-center flex-row align-items-center">
			<Navbar.Brand >
				<h3><img height="100px" alt='logo' src={require('../images/logo_preta.png')} /></h3> 
			</Navbar.Brand>
		</Navbar>
	)
}
