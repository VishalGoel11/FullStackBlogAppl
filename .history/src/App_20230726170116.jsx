import { useState } from 'react'
import { Link } from 'react-router-dom'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './components/Home.jsx'
function App() {

  return (
    <>
    <div>
      <li>
        <Link to='/'>home</Link>
      </li>
    </div>
    
    <div className="container mt-3">
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/private" element={<Private />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
        </Routes>
      </div>
    </>
  )
}

export default App
