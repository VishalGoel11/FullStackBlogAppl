import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Home from './Home'
function Navbar() {

  return (
    <div className='flex justify-around list-none bg-black text-white h-12 place-items-center'>
    <div className='flex justify-between'>
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
    <div className='flex justify-between'>
      <li>
        <Link to={'/login'}>Login</Link>
      </li>
      <li>
        <Link to={'/signin'}>Sign up</Link>
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
