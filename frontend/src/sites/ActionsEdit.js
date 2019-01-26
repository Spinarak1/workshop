import React, {Component} from 'react';
import {Button, Form, FormControl, FormGroup, Label} from "react-bootstrap";
import {withRouter} from 'react-router-dom';

class ClientsEdit extends Component {

    emptyItem = {
        amount: '',
        description: '',
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
            const action = await (await fetch(`/war/actions/${this.props.match.params.id}`)).json();
            this.setState({item: action});
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
        await fetch('/war/actions', {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/actions');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Action' : 'Add Action'}</h2>;
        return <div>
            <header className="App-header">
                <div>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="amount">Amount</Label>
                            <FormControl type="text" name="amount" id="amount" value={item.amount || ''}
                                         onChange={this.handleChange} autoComplete="amount"/>
                        </FormGroup>
                        <FormGroup>
                            <Label fluid for="description">Description</Label>
                            <FormControl type="text" name="description" id="description" value={item.description || ''}
                                         onChange={this.handleChange} autoComplete="description"/>
                        </FormGroup>
                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>{' '}
                            <Button color="secondary" href="/actions">Cancel</Button>
                        </FormGroup>
                    </Form>
                </div>
            </header>
        </div>
    }
}

export default withRouter(ClientsEdit);