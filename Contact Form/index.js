//primero declarar las variables
const form = document.getElementById('form')
const username = document.getElementById('username');
const lastname = document.getElementById('lastname');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');

//add an event listener on form submit

form.addEventListener('submit', e => {
    e.preventDefault()

    validateInputs();
});

function reset(){
    
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.remove('success');
    inputControl.classList.remove('error'); 

    document.getElementById('form').reset();

}


const setError = (element, message) => {
    const inputContorl = element.parentElement;
    const errorDisplay = inputContorl.querySelector('.error');

    errorDisplay.innerText = message;
    inputContorl.classList.add('error');
    inputContorl.classList.remove('success');
};

const setSuccess = element => {
    const inputContorl = element.parentElement;
    const errorDisplay = inputContorl.querySelector('.error');

    errorDisplay.innerText = '';
    inputContorl.classList.add('success');
    inputContorl.classList.remove('error'); 
};

const isValidPhone = phone => {
    const ph = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/
    return ph.test(phone);
}

const isValidEmail = email => {
    const re =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return re.test(String(email).toLocaleLowerCase())
}


//create the functions

const validateInputs = () => {
    const userameValue = username.value.trim();
    const lastnamevalue = lastname.value.trim();
    const phoneValue = phone.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();

//conditions
    if (userameValue === '') {
        setError(username, 'Username is Require')
    } else {
        setSuccess(username)
    };

    if (lastnamevalue === '') {
        setError(lastname, 'Lastname is require')
    } else {
        setSuccess(lastname)
    };

    if (phoneValue === '') {
        setError(phone, 'Phone Number is require')
    } else if(!isValidPhone(phoneValue)) {    
        setError(phone, 'Provide a valid phone number')
    } else {
        setSuccess(phone)
    };

    if (emailValue === '') {
        setError(email, ' email is require')
    } else if(!isValidEmail(emailValue)) {    
        setError(email, 'Provide a valid email address')
    } else {
        setSuccess(email)
    };

    if (passwordValue === '') {
        setError(password, 'Password is require')
    } else if (passwordValue.length < 8) {
        setError(password, 'password must be at least 8 character.')
    } else {
        setSuccess(password);
    }

    if (password2 === ''){
        setError(password2, 'please confirm your password')
    } else if(password2Value !== passwordValue){
        setError(password2, 'password doesnt match')
    } else {
        setSuccess(password2);
    }



}
