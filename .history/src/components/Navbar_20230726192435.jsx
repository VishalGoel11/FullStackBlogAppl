import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Home from './Home'
import Login from './Login'
import Signup from './Signup'
import Private from './Private'
function Navbar() {

  return (
    <div className='fixed w-screen flex justify-around list-none bg-white text-black h-12 place-items-center'>
    <div className='flex justify-between w-32'>
      <li>
        <Link to={'/'}>Home</Link>
      </li>
      <li>
        <Link to={'/private'}>Private</Link>
      </li>
    </div>
    <div>
      <li>
        <a href="/">Logout</a>
      </li>
    </div>
    <div className='flex justify-between w-32'>
      <li>
        <Link to={'/login'}>Login</Link>
      </li>
      <li>
        <Link to={'/signup'}>Sign up</Link>
      </li>
    </div>
    
    {/* <div className="">
        <Routes>

          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/private" element={<Private />} />
        </Routes>
      </div> */}
    </div>
    
  )
}

export default Navbar
