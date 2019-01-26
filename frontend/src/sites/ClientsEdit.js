import React, {Component} from 'react';
import {Button, Form, FormControl, FormGroup, Label} from "react-bootstrap";
import {withRouter} from 'react-router-dom';

class ClientsEdit extends Component {

    emptyItem = {
        name: '',
        surname: '',
        address: '',
        phoneNumber: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const client = await (await fetch(`/war/clients/${this.props.match.params.id}`)).json();
            this.setState({item: client});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
        await fetch('/war/clients', {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/clients');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Client' : 'Add Client'}</h2>;
        return <div>
            <header className="App-header">
                <div>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="name">Name</Label>
                            <FormControl type="text" name="name" id="name" value={item.name || ''}
                                         onChange={this.handleChange} autoComplete="name"/>
                        </FormGroup>
                        <FormGroup>
                            <Label fluid for="surname">Surname</Label>
                            <FormControl type="text" name="surname" id="surname" value={item.surname || ''}
                                         onChange={this.handleChange} autoComplete="surname"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="address">Address</Label>
                            <FormControl type="text" name="address" id="address" value={item.address || ''}
                                         onChange={this.handleChange} autoComplete="address"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="phoneNumber">Phone Number</Label>
                            <FormControl type="text" name="phoneNumber" id="phoneNumber" value={item.phoneNumber || ''}
                                         onChange={this.handleChange} autoComplete="phoneNumber"/>
                        </FormGroup>
                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>{' '}
                            <Button color="secondary" href="/clients">Cancel</Button>
                        </FormGroup>
                    </Form>
                </div>
            </header>
        </div>
    }
}

export default withRouter(ClientsEdit);