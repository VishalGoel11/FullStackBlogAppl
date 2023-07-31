import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Home from './Home'
function Navbar() {

  return (
    <div className='flex justify-around list-none'>
    <div className='flex justify'>
      <li>
        <Link to={'/home'}>home</Link>
      </li>
      <li>
        <Link>Private</Link>
      </li>
    </div>
    <div>
      <li>
        <a href="">Logout</a>
      </li>
    </div>
    <div className='flex'>
      <li>
        <Link>Login</Link>
      </li>
      <li>
        <Link>Sign up</Link>
      </li>
    </div>
    
    <div className="">
        <Routes>
          <Route path="/home" element={<Home />} />
        </Routes>
      </div>
    </div>
  )
}

export default Navbar
