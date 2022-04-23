import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    useEffect(() => {

        getAllEmployees();
    }, [])

    const getAllEmployees = () => {
        EmployeeService.getAllEmployees().then((response) => {
            setEmployees(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deleteEmployee = (employeeId) => {
       EmployeeService.deleteEmployee(employeeId).then((response) =>{
        getAllEmployees();

       }).catch(error =>{
           console.log(error);
       })
        
    }

    return (
        <div className = "container">
            <h2 className = "text-center"> Lista de funcionários </h2>
            <Link to = "/add-employee" className = "btn btn-primary mb-2" > Adicionar </Link>
            <table className="table table-bordered table-striped">
                <thead>
                    <th> Id </th>
                    <th> Primeiro nome </th>
                    <th> Ultimo nome</th>
                    <th> Endereço de e-mail </th>
                    <th> Ações </th>
                </thead>
                <tbody>
                    {
                        employees.map(
                            employee =>
                            <tr key = {employee.id}> 
                                <td> {employee.id} </td>
                                <td> {employee.firstName} </td>
                                <td>{employee.lastName}</td>
                                <td>{employee.emailId}</td>
                                <td>
                                    <Link className="btn btn-info" to={`/edit-employee/${employee.id}`} >Atualizar</Link>
                                    <button className = "btn btn-danger" onClick = {() => deleteEmployee(employee.id)}
                                    style = {{marginLeft:"10px"}}> Apagar</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent
