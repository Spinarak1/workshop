import React, {Component} from 'react';
import NavigationBar from "../components/NavigationBar";
import logo from "../logo.svg";
import {Button, ButtonGroup, Table} from "react-bootstrap";

class Clients extends Component {

    constructor(props) {
        super(props);
        this.state = {clients: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('war/clients')
            .then(response => response.json())
            .catch(err => console.log('Error while fetching clients: ', err))
            .then(data => this.setState({clients: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/war/clients/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedClients = [...this.state.clients].filter(i => i.id !== id);
            this.setState({clients: updatedClients});
        });
    }

    render() {
        const {clients, isLoading} = this.state;

        if (isLoading) {
            return (
                <div>
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <p>Loading...</p>
                    </header>
                </div>);
        }

        const clientsList = clients.map(clients => {
            return <tr key={clients.id}>
                <td>{clients.name}</td>
                <td>{clients.surname}</td>
                <td>{clients.adress}</td>
                <td>{clients.phoneNumber}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" bsStyle="primary" href={"/clients/" + clients.id}>Edit</Button>
                        <Button size="sm" bsStyle="danger" onClick={() => this.remove(clients.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <header className="App-header">
                    <NavigationBar/>
                    <div fluid>
                        <div align="right">
                            <Button bsStyle="success" href="/clients/new">Add Client</Button>
                        </div>
                        <h3>Clients</h3>
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Address</th>
                                <th>Phone Number</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {clientsList}
                            </tbody>
                        </Table>
                    </div>
                </header>
            </div>
        );
    }
}


export default Clients;
