
import React from 'react';
import './App.css';



function App() {

  const onFormSubmit = event => {
    if(event.code === "Enter" || event.code === "NumpadEnter"){
      console.log("Enter key was pressed. Run your function.");
      event.preventDefault();
    };

    document.addEventListener('keydown', onFormSubmit);
    return() => {
      document.removeEventListener('keydown', onFormSubmit)
    };
  };
  
  
  return (
    <div className='main container-fluid'>
      <div className='sub-main row'>
        <div className='row'>
          <h2 className='title'>Login Form</h2>
        </div>
            <form onSubmit={onFormSubmit}>
              <div className="form-group">
                <input type="text" className="form-control no-border mb-3 " id="Username"  placeholder="Enter Username"/>
              </div>
              <div className="form-group">
                <input type="password" className="form-control mb-3" id="exampleInputPassword1" placeholder="Password"/>
              </div>
              <div className='col-sm-6 offset-3'>
                <button type='submit' className='btn btn-primary'>submit</button>
              </div>
        
            </form>
  
      </div>
    </div>
  )};


export default App;