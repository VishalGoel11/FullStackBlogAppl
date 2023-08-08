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
        <a href="">Logout</a>
      </li>
    </div>
    <div>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Harum a fugit tenetur eius nihil neque maiores corporis iure aperiam, sit, ex ipsum enim reprehenderit quidem totam fuga autem hic! Eligendi.
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
