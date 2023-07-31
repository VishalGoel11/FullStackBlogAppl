import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Home from './components/Home.jsx'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <nav>
      <div>
        <li>
        <Link to="/home">Home</Link>
        </li>
        {/* <li>
          <Link>Private</Link>
        </li> */}
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
    <div>
      <Routes>
        <Route path='/home' element={<Home />}/>
      </Routes>
    </div>
    </>
  )
}

export default App
