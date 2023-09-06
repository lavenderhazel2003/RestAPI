import {SignIn,SignUp,Dashboard} from './components'
import './App.css'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'

function App() {
  

  return (
    <Router>
      <Routes>
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/" element={<SignIn/>}/>
        <Route path="/dashboard" element={<Dashboard/>}/>
      </Routes>
    </Router>
  )
}

export default App
