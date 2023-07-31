import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Home from './Home'
import Login from './Login'
import Signup from './Signup'
import Private from './Private'
function Navbar() {

  return (
    <div className='fixed w-screen flex  list-none bg-black text-white h-12 place-items-center'>
    <div className='flex justify-between'>
      <li>
        <Link to={'/'}>home</Link>
      </li>
      <li>
        <Link to={'/private'}>Private</Link>
      </li>
    </div>
    <div>
      <li>
        <a href="">Logout</a>
      </li>
    </div>
    <div className='flex justify-between'>
      <li>
        <Link to={'/login'}>Login</Link>
      </li>
      <li>
        <Link to={'/signup'}>Sign up</Link>
      </li>
    </div>
    
    <div className="">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/private" element={<Private />} />
        </Routes>
      </div>
    </div>
    
  )
}

export default Navbar
