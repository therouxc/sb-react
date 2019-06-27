import React, { Component } from 'react';
import Axios from 'axios';
import Table from 'react-bootstrap/Table'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'

class ToDo extends Component {
  
  constructor(props) {
    super(props)
    this.createTask = this.createTask.bind(this)
    this.handleInputChange = this.handleInputChange.bind(this)
  }

  state = {
    tasks: [],
    newName: '',
    newDescription: ''
  }
  
  render() {

    const todoList = this.state.tasks.map((task) => 
        <tr>
          <td>{task.name}</td>
          <td>{task.description}</td>
          <td>{String(task.complete)}</td>
          <td>
            <Button variant="danger" onClick={() => this.deleteTask(task.name)}>X</Button>
          </td>
        </tr>
      )

    return (
      <Container>
        <Row>
          <Form onSubmit={this.createTask}>
            <Form.Row>
              <Col>
              <Form.Control type="text" value={this.state.newName} name="newName" onChange={this.handleInputChange} placeholder='name'/>
              </Col>
              <Col>
              <Form.Control type="text" value={this.state.newDescription} name="newDescription" onChange={this.handleInputChange} placeholder='description'/>
              </Col>
              <Col>
              <Button type="submit">Add Task</Button>
              </Col>
            </Form.Row>
          </Form>
        </Row>
        <Row>
          <Table bordered>
            <thead>
              <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Completed</th>
                <th>Remove</th>
              </tr>
            </thead>
            <tbody>
              {todoList}
            </tbody>
          </Table>
        </Row>
      </Container>
    )
  }

  getRandomTask() {
    Axios.get('/getAllTasks').then(res => {
      this.setState({
        //tasks: this.state.tasks.concat(res.data)
        tasks: res.data
      })
    })
  }

  createTask(event) {
    console.log(event)
    const task = {
      name: this.state.newName,
      description: this.state.newDescription,
      complete: false
    }

    this.setState({tasks: this.state.tasks.concat({
      name: task.name,
      description: task.description,
      complete: task.complete
    })})

    Axios.put('/createTask', {
      name: task.name,
      description: task.description,
      complete: task.complete
    })
      .then(res => {
        console.log(res);
        console.log(res.data);
      })

    this.resetInputs()
    event.preventDefault()
  }

  handleInputChange(event) {
    console.log(event)
    const name = event.target.name
    this.setState({
      [name]: event.target.value
    })
  }

  componentDidMount() {
    this.getRandomTask()
  }

  resetInputs() {
    this.setState({
      newName: "",
      newDescription: ""
    })
  }

  deleteTask(name) {
    Axios.delete('/deleteTaskByName/' + name)
    .then(res => {
      console.log(res);
      console.log(res.data);
    })
    window.location.reload();
  }
}

export default ToDo