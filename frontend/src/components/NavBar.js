import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar'
import NavbarBrand from 'react-bootstrap/NavbarBrand';

class NavBar extends Component {
  render() {
    return (
      <Navbar bg='dark' variant="dark">
        <NavbarBrand>
          Todo Lists
        </NavbarBrand>
      </Navbar>
    )
  }
}

export default NavBar