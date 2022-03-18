import WebServer from "./web.server"

let webServer = new WebServer() 

webServer.start()
.then(() => {
    console.log('web server started')  
})
.catch(err => {
    console.error(err)
    console.error('failed to start web server')
})