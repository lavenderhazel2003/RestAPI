import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { AiOutlineShoppingCart } from 'react-icons/ai'
import { AiOutlinePlus } from 'react-icons/ai'
import {BsFillTrashFill} from 'react-icons/bs'
import {BiPencil} from 'react-icons/bi'
import Modal from './Modal';
import ModalUpdate from './ModalUpdate';


const Products = () => {
    const [products, setProducts] = useState([]);
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [quantity, setQuantity] = useState("");


    const getProducts = async () => {
        axios.get("http://localhost:8080/showStock").then((res) => {
            setProducts(res.data);
        }
        );
    }

    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isModalOpenUpdate, setIsModalOpenUpdate] = useState(false);

    const openModal = () => {
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
    };

    const openModalUpdate = () => {
        setIsModalOpenUpdate(true);
    };
    
    const closeModalUpdate = () => {
        setIsModalOpenUpdate(false);
    };

    useEffect(() => {
        getProducts();
    }, []);

    const [cart, setCart] = useState([])

    const handleClic = (item) => {
        // Check if the item is already in the cart
        const index = cart.findIndex((cartItem) => cartItem.name === item.name);

        if (index >= 0) {
            // If the item is already in the cart, update its quantity
            const updatedCart = [...cart];
            updatedCart[index].quantity += 1;
            setCart(updatedCart);
            localStorage.setItem('cart', JSON.stringify(updatedCart));
        } else {
            // If the item is not in the cart, add it with a quantity of 1
            const updatedCart = [...cart, { ...item, quantity: 1 }];
            setCart(updatedCart);
            localStorage.setItem('cart', JSON.stringify(updatedCart));
        }
        console.log(localStorage.getItem('cart'));
    };

    

    const deleteProduct = (id) => {
        axios.delete(`http://localhost:8080/deleteStock?id=${id}`).then((res) => {
            console.log(res.data);
            window.location.reload();
        });
    }




    return (


        <div className="flex flex-wrap ">
            {products.map((product, index) => (
                <div
                    key={index}
                    className="block  m-3 px-3 w-44 h-auto rounded-lg bg-gray-300 shadow-[0_2px_15px_-3px_rgba(0,0,0,0.07),0_10px_20px_-2px_rgba(0,0,0,0.04)] dark:bg-neutral-700"
                >

                    <div className="p-6">
                        <h5 className="mb-2 text-xl font-medium leading-tight text-neutral-800 dark:text-neutral-50">
                            {product.name}
                        </h5>
                        <p className="mb-4 text-base text-neutral-600 dark:text-neutral-200">
                            ${product.stock_price}
                        </p>
                        <p className="mb-4 text-base text-neutral-600 dark:text-neutral-200">
                            {product.no_of_stocks} in stock
                        </p>
                    </div>

                    <div className=" flex justify-around items-center mb-2">
                        <button
                            className="rounded bg-blue-500 p-3 "
                            onClick={() => handleClic({id:product.id, name: product.name, price: product.stock_price })}
                        >
                            <AiOutlineShoppingCart />
                        </button>
                        <button
                            className="rounded bg-yellow-500 p-3 "
                           onClick={()=>openModalUpdate()}
                        >
                            <BiPencil />
                        </button>
                        <button
                            className="rounded bg-red-500 p-3 "
                           onClick={()=>deleteProduct(product.id)}
                        >
                            <BsFillTrashFill />
                        </button>

                    </div>
                {isModalOpenUpdate && <ModalUpdate isOpen={isModalOpenUpdate} onClose={closeModalUpdate} product={product} />}

                </div>
            ))}
            <div>
                <div
                    className="block flex justify-center items-center cursor-pointer  m-3 px-3 w-44 h-64 rounded-lg bg-gray-300 shadow-[0_2px_15px_-3px_rgba(0,0,0,0.07),0_10px_20px_-2px_rgba(0,0,0,0.04)] dark:bg-neutral-700"
                    onClick={openModal}
                >
                    <AiOutlinePlus className="text-5xl text-blue-500" />
                </div>

                {/* Render the Modal component conditionally */}
                {isModalOpen && <Modal isOpen={isModalOpen} onClose={closeModal} />}
            </div>
        </div>


    );
}

export default Products