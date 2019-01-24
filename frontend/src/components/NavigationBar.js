import React, {Component} from 'react';
import {Navbar, Nav, NavItem} from 'react-bootstrap';

class NavigationBar extends Component {
    render() {
        return (
            <Navbar>
                <Nav>
                    <NavItem eventKey={1} href="actions">
                        Actions
                    </NavItem>
                    <NavItem eventKey={2} href="clients">
                        Clients
                    </NavItem>
                    <NavItem eventKey={3} href="services">
                        Services
                    </NavItem>
                </Nav>
                <Nav pullRight>
                    <NavItem eventKey={1} href="/">
                        Home
                    </NavItem>
                </Nav>
            </Navbar>
        );
    }
}

export default NavigationBar;