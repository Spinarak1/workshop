import React, {Component} from 'react';
import NavigationBar from "../components/NavigationBar";
import logo from "../logo.svg";
import {Button, Table} from "react-bootstrap";

class Services extends Component {
    constructor(props) {
        super(props);
        this.state = {services: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('war/services')
            .then(response => response.json())
            .catch(err => console.log('Error while fetching services: ', err))
            .then(data => this.setState({services: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/war/services/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedServices = [...this.state.services].filter(i => i.id !== id);
            this.setState({clients: updatedServices});
        });
    }

    render() {
        const {services, isLoading} = this.state;

        if (isLoading) {
            return (
                <div>
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <p>Loading...</p>
                    </header>
                </div>);
        }

        const servicesList = services.map(services => {
            return <tr key={services.id}>
                <td>{services.client.name} {services.client.surname}</td>
                <td>{services.description}</td>
                <td>{services.dateOfAcceptance.substring(0, 10)}</td>
                <td>{services.endDate.substring(0, 10)}</td>
                <td>
                    <Button size="sm" bsStyle="danger" onClick={() => this.remove(services.id)}>Delete</Button>
                </td>
            </tr>
        });

        return (
            <div>
                <header className="App-header">
                    <NavigationBar/>
                    <div>
                        <h3>Services</h3>
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th>Client</th>
                                <th>Description</th>
                                <th>Started</th>
                                <th>Finished</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {servicesList}
                            </tbody>
                        </Table>
                    </div>
                </header>
            </div>
        );
    }
}

export default Services;
