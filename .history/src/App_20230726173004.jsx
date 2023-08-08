import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './components/Home.jsx'
function App() {

  return (
    <>
    <div>
      <li>
        <Link to={'/home'}>home</Link>
      </li>
      <li>
        <Link>Private</Link>
      </li>
    </div>
    <div>
      <li>
        link
      </li>
    </div>
    
    <div className="container mt-3">
        <Routes>
          <Route path="/home" element={<Home />} />
        </Routes>
      </div>
    </>
  )
}

export default App
