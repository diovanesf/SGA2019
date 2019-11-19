import React from 'react'
import Container from 'react-bootstrap/Container'
import { Header } from './Header'
export const Page = (props) => {
	return (
		<div>
			<Header />
			<Container
				className='bg-white mt-lg-2 p-4 mx-lg-4 '
				fluid
                bsPrefix='lg'
                style={{...props.style}}
                {...props}
			>
				{props.children}
			</Container>
		</div>
	)
}
