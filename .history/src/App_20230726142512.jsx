import { useState } from 'react'
import { Link } from 'react-router-dom'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './components/Home.jsx'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <nav>
      <div>
        <li>
        <Link>Home</Link>
        </li>
        <li>
          <Link>Private</Link>
        </li>
      </div>
      <div>
        <li>
          <a>Logout</a>
        </li>
      </div>
      <div>
        <li>
          <Link>Login</Link>
        </li>
        <li></li>
      </div>
    </nav>
    </>
  )
}

export default App
