import React, { useState } from "react";
import axios from "axios";
import {Link} from 'react-router-dom'


const SignUp = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUserName] = useState("");
    const [role, setRole] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        const user = { email, password, role, username };
        axios.post("http://localhost:8080/user", user).then((res) => {
            alert("User Created");
            window.location.href = "/";
        });
    
    };
    return (
        <div className="grid lg:grid-cols-2 items-center   ">
            <div className="lg:col-span-1 m-9">

                <img
                    src='https://res.cloudinary.com/djdhjstoc/image/upload/v1692443892/login-vector_igi1li.jpg'
                    alt="Image"
                    priority
                />
            </div>
            <div className=" lg:col-span-1 ">
                <div className="bg-blue-300 shadow-lg rounded-lg m-9 p-8 mb-8">
                    <h3 className="text-3xl text-center items-center mb-8 font-semibold border-b pb-4">SignUp</h3>
                    <input type="text" onChange={(e) => setUserName(e.target.value)} className="py-2 px-4 my-2 outline-none w-full rounded-lg focus:ring-2 focus:ring-gray-200 bg-gray-100 text-gray-700" placeholder="Username" />
                    <input type="email" onChange={(e) => setEmail(e.target.value)} className="py-2 px-4 my-2 outline-none w-full rounded-lg focus:ring-2 focus:ring-gray-200 bg-gray-100 text-gray-700" placeholder="Email" />

                    <input type="password" onChange={(e) => setPassword(e.target.value)} className="py-2 px-4 my-2 outline-none w-full rounded-lg focus:ring-2 focus:ring-gray-200 bg-gray-100 text-gray-700" placeholder="Password" />


                    <label for="role">Select a Role:</label>
                    <select id="role" name="role" onChange={(e) => setRole(e.target.value)}>
                        <option value="user" >User</option>
                        <option value="manager">Manager</option>
                    </select>

                    <div className="mt-8">
                        <button type="button" onClick={handleSubmit} className="transition duration-500 ease hover:green-4 inline-block bg-[#F07535] text-lg font-medium rounded-full text-white px-8 py-3 cursor-pointer">Signup</button>
                    </div>
                </div>
                <div className="mx-10">
                    Already have an account?<Link to='/' className='mx-2 text-blue-500'>SignIn</Link>
                </div>
            </div>
        </div>



    )
}

export default SignUp