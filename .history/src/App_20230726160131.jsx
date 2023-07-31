import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import Home from './components/Home';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <header>
        <img src={reactLogo} alt="React Logo" />
        <h1>Welcome to My React App</h1>
      </header>
      <main>
        <Home />
      </main>
      <footer>
        <p>This is the footer of the app.</p>
      </footer>
    </>
  );
}

export default App;
