import axios from 'axios';
import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'


const SignIn = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error , setError] = useState("");
    const [authenthicated , setAuthenthicated] = useState(false);
   

    const handleSubmit = (e) => {
        e.preventDefault();
        const checkuser = { email, password };
        axios.get(`http://localhost:8080/user/auth?email=${email}&password=${password}`, checkuser).then((res) => {
            if(res.data !== "ok")
            setError(res.data);
            else{
                setAuthenthicated(true);
                localStorage.setItem("authenthicated",authenthicated);
                axios.get(`http://localhost:8080/user/find?email=${email}`).then((res) => {
                    localStorage.setItem("user",JSON.stringify(res.data));
                });
                window.location.href = "/dashboard";
            }
            
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
                    <h3 className="text-3xl text-center items-center mb-8 font-semibold border-b pb-4">Login</h3>

                    <input type="email" onChange={(e) => setEmail(e.target.value)} className="py-2 px-4 my-2 outline-none w-full rounded-lg focus:ring-2 focus:ring-gray-200 bg-gray-100 text-gray-700" placeholder="Email" />

                    <input type="password" onChange={(e) => setPassword(e.target.value)} className="py-2 px-4 my-2 outline-none w-full rounded-lg focus:ring-2 focus:ring-gray-200 bg-gray-100 text-gray-700" placeholder="Password" />


                    {error && <div className="text-red-500">{error}</div>}

                    <div className="mt-8">
                        <button type="button" onClick={handleSubmit} className="transition duration-500 ease hover:green-4 inline-block bg-[#F07535] text-lg font-medium rounded-full text-white px-8 py-3 cursor-pointer">Login</button>
                    </div>
                </div>
                <div className='mx-10'>
                    Create a new account?<Link to='/signup' className='mx-2 text-blue-500'>SignUp</Link>

                </div>
            </div>
        </div>
    )
}

export default SignIn
