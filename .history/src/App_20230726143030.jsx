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
g        </li>
        <li>
h        </li>
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
        <li>
          <Link>Sign up</Link>
        </li>
      </div>
    </nav>
    <Home/>
    </>
  )
}

export default App
