import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Cart(props) {


    const [isOpen, setIsOpen] = useState(false);

    const showModal = () => setIsOpen(true);
    const hideModal = () => setIsOpen(false);

    const Done = () => window.location.reload();
    const Click = () => {
        console.log(props.cart);
       
        alert("Your Order is Placed Successfully");

       for(let i=0;i<props.cart.length;i++){
        axios.put(`http://localhost:8080/buyStock?id=${props.cart[i].id}&count=${props.cart[i].quantity}`).then((res) => {
            console.log(res.data);
           
        });
       }


       props.setCart({});
       localStorage.removeItem('cart');
       window.location.reload();
    }
    const delCharge = 60;
    const [totalPrice, setTotalPrice] = useState(
        props.cart?.reduce((total, item) => total + item.price * item.quantity, 0)
    );


    const updateCart = (index, newQuantity) => {
        if (newQuantity <= 0) removeItem(index)
        else {
            const updatedCart = [...props.cart];
            updatedCart[index].quantity = newQuantity;
            console.log(updatedCart[index].quantity);
            props.setCart(updatedCart);
            localStorage.setItem('cart', JSON.stringify(updatedCart));

            const newTotalPrice = updatedCart.reduce(
                (total, item) => total + item.price * item.quantity,
                0
            );
            setTotalPrice(newTotalPrice);
        }
    };


    const removeItem = (index) => {
        const updatedCart = [...props.cart];
        updatedCart.splice(index, 1);
        props.setCart(updatedCart);
        localStorage.setItem('cart', JSON.stringify(updatedCart));

        const newTotalPrice = updatedCart.reduce(
            (total, item) => total + item.price * item.quantity,
            0
        );
        setTotalPrice(newTotalPrice);
    };

    const clearCart = () => {
        props.setCart([]);
        localStorage.setItem('cart', JSON.stringify([]));
        setTotalPrice(0);
    };
    useEffect(() => {
        // const cartFromLocalStorage = JSON.parse(localStorage.getItem('cart'));
        // if (cartFromLocalStorage) {
        //   props.setCart(cartFromLocalStorage);
        // }
      }, [props.cart]); 
      

    return (
        // <div className="conatiner ">
        <div className="flex flex-wrap my-5 container">
            <div className="md:w-1/2 sm:w-full my-4 bg-gray-200 " >
                <div className=" text-center my-5">
                    <h3 className=" text-blue-500" >
                        GET YOUR FREE SHIPPING WITH OUR CREW. ON EVERY ORDER. EVERY TIME
                    </h3>
                    <small className="text-red-500">Read the terms and conditions</small>
                    <br />
                </div>
                <div className="my-3 bg-dark font-bold text-light text-center p-2">
                    <h3>
                        Your Cart {props.cart == 0 ? null : <span>({props.cart.length})</span>}
                    </h3>
                </div>
                <div className="p-0 ">
                    <ul>
                        {props.cart.map((item, index) => (
                            <div className="flex p-3 justify-between text-black" key={index}>
                                <div className="w-1/4 font-bold">{item.name}</div>
                                <div className="w-1/4">{item.price}</div>
                                <div className="w-1/4">
                                    <button className="bg-blue-500 p-2 px-2.5 rounded" onClick={() => updateCart(index, item.quantity - 1)}>-</button>
                                    <span className="mx-2">{item.quantity}</span>
                                    <button className="bg-blue-500 p-2 rounded" onClick={() => updateCart(index, item.quantity + 1)}>+</button>
                                </div>
                                <div className="w-1/4">{item.price * item.quantity}</div>
                                <div className="w-1/4">
                                    <button className="bg-red-500 p-1 rounded" onClick={() => removeItem(index)}>Remove</button>
                                </div>
                            </div>
                        ))}
                    </ul>
                </div>
            </div>
            <div className="md:w-1/2 sm:w-full my-2">
                <div className="card bg-gray-800 text-white text-center justify-center m-2">
                    <div className="p-3">
                        <h1 className="text-2xl font-semibold text-blue-500">Summary</h1>
                        <div className="flex justify-between mt-4">
                            <p className="w-1/2">SUBTOTAL</p>
                            <p className="w-1/2">{totalPrice}</p>
                        </div>
                        <div className="flex justify-between">
                            <p className="w-1/2">DELIVERY CHARGES</p>
                            <p className="w-1/2">{totalPrice ? delCharge : ''}</p>
                        </div>
                        <div className="flex justify-between">
                            <p className="w-1/2">TAX</p>
                            <p className="w-1/2">{(totalPrice * 0.01).toFixed(2)}</p>
                        </div>
                        <div className="flex justify-between">
                            <h2 className="w-1/2 text-info">TOTAL</h2>
                            <h2 className="w-1/2">
                                {totalPrice && ((totalPrice + totalPrice * 0.01) + delCharge).toFixed(2)}
                            </h2>
                        </div>
                        <div className="m-3 p-2">
                            <button className="bg-red-500 p-1 rounded m-2" onClick={clearCart}>
                                Empty Cart
                            </button>
                            <button className="bg-green-500 p-1 rounded m-2" onClick={Click}>
                                BUY
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    )
}
export default Cart