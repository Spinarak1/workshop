import React, {Component} from 'react';
import NavigationBar from "../components/NavigationBar";
import logo from "../logo.svg";
import {Button, ButtonGroup, Table} from "react-bootstrap";

class Actions extends Component {

    constructor(props) {
        super(props);
        this.state = {actions: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('war/actions')
            .then(response => response.json())
            .catch(err => console.log('Error while fetching actions: ', err))
            .then(data => this.setState({actions: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/war/actions/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedActions = [...this.state.actions].filter(i => i.id !== id);
            this.setState({actions: updatedActions});
        });
    }

    render() {
        const {actions, isLoading} = this.state;

        if (isLoading) {
            return (
                <div>
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <p>Loading...</p>
                    </header>
                </div>);
        }

        const actionsList = actions.map(actions => {
            return <tr key={actions.id}>
                <td>{actions.amount}</td>
                <td>{actions.description}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" bsStyle="primary" href={"/actions/" + actions.id}>Edit</Button>
                        <Button size="sm" bsStyle="danger" onClick={() => this.remove(actions.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <header className="App-header">
                    <NavigationBar/>
                    <div>
                        <div align="right">
                            <Button bsStyle="success" href="/actions/new">Add Action</Button>
                        </div>
                        <h3>Actions</h3>
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Description</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {actionsList}
                            </tbody>
                        </Table>
                    </div>
                </header>
            </div>
        );
    }
}

export default Actions;