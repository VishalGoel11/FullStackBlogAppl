import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
<<<<<<< HEAD
import "./index.css"
import Home from './components/Landing Page/Home'
=======
import './App.css'
>>>>>>> 3cc5219a08bccc91dbd31f7bb0411244bb1e420c

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
<<<<<<< HEAD
    <Home/>
=======
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
>>>>>>> 3cc5219a08bccc91dbd31f7bb0411244bb1e420c
    </>
  )
}

export default App
