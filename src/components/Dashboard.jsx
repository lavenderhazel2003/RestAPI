import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Products from './Products';
import Cart from './Cart';


const Dashboard = () => {
  const [cart, setCart] = useState([])
  useEffect(() => {
    const cart = JSON.parse(localStorage.getItem('cart'));
    if (cart) setCart(cart);
  }, []);
  
  return (
    <>
    {/* <div className="w-4/5  my-2 ">
    </div>
    <div className="w-1/5 my-2">
  </div> */}
      <Cart cart={cart} setCart={setCart} />
      <Products/>
    </>
    
  );
};

export default Dashboard;
