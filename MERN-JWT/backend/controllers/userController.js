const jwt = require('jsonwebtoken')
const bcrypt = require('bcryptjs')
const asyncHandler = require('express-async-handler')
const User = require('../models/userModels')

//@desc     Register new user
//@route    POST /api/users/
//@Access   Public
const registerUser = asyncHandler( async (req, res) => {
    const {name, email, password} = req.body

    if(!name || !email || !password){
        res.status(400)
        throw new Error('Please complete all the fields')
    }

    // check if user exist
    const userExist = await User.findOne({email})

    if(userExist){
        res.status(400)
        throw new Error('User already exist')
    }

    //Hash the password
    const salt = await bcrypt.genSalt(10)
    const hashedPassword = await bcrypt.hash(password, salt)

    //create User
    const user = await User.create({
        name,
        email,
        password: hashedPassword
    })

    if(user){
        res.status(201).json({
            _id: user.id,
            name: user.name,
            email: user.email,
            token: generateToken(user._id),
        })
    } else {
        res.status(400)
        throw new Error('Invalid User Data')
    }

    res.json({message: 'Register User'})
});

//@desc     authenticate an user
//@route    POST /api/users/login
//@Access   Public
const loginUser = asyncHandler( async (req, res) => {
    const {email, password} = req.body

    //check for user email
    const user = await User.findOne({email})
    
    if (user && (await bcrypt.compare(password, user.password))) {
        res.status(201).json({
            _id: user.id,
            name: user.name,
            email: user.email,
            token: generateToken(user._id), 
        })
    } else {
        res.status(400)
        throw new Error('Invalid Credentials')
    }
});

//@desc     get user data
//@route    GET /api/users/me
//@Access   Private
const getMe = asyncHandler( async(req, res) => {
    res.status(200).json(req.user)
});

//generate JWT
const generateToken = (id) => {
    return jwt.sign({ id }, process.env.JWT_SECRET, {
        expiresIn: '30d'
    })
}

module.exports = {
    registerUser,
    loginUser,
    getMe,
}