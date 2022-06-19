import { join } from 'path'
import path from 'path'
import { createReadStream } from 'fs'
import { createServer } from 'http'
import {fileURLToPath} from 'url';
import { networkInterfaces } from 'os';
import fs from 'fs'

const {PORT = 3000} = process.env

const HTML_CONTENT_TYPE = 'text/html'
const CSS_CONTENT_TYPE = 'text/css'
const JS_CONTENT_TYPE = 'text/javascript'
const nets = networkInterfaces();
const results = Object.create(null);

for (const name of Object.keys(nets)) {
	for (const net of nets[name]) {
		const familyV4Value = typeof net.family === 'string' ? 'IPv4' : 4
        if (net.family === familyV4Value && !net.internal) {
            if (!process.env.LOCAL_IP) {
				process.env['LOCAL_IP'] = net.address
            }
        }
	}	
}

fs.readFile('./src/public/app/notification_file.js', 'utf8', function (err,data) {
  if (err) {
    return console.log(err);
  }
  var result = data.replace(/localhost/g, process.env.LOCAL_IP);

  fs.writeFile('./src/public/app/notification.js', result, 'utf8', function (err) {
     if (err) return console.log(err);
  });
});

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const PUBLIC_FOLDER = join(__dirname, 'src/public')

const requestListener = (req, res) => {
  const {url} = req
	console.log("url -> "+url)
  let statusCode = 200
  let contentType = HTML_CONTENT_TYPE
  let stream 

  
  if (url === '/') {
    stream = createReadStream(`${PUBLIC_FOLDER}/index.html`)
  } else if (url.match("\.css$")) { // para los archivos CSS
    contentType = CSS_CONTENT_TYPE
    stream = createReadStream(`${PUBLIC_FOLDER}${url}`)
  } else if (url.match("\.js$")) { // para los archivos JavaScript
    contentType = JS_CONTENT_TYPE
    stream = createReadStream(`${PUBLIC_FOLDER}${url}`)
  } else { // si llegamos aquí, es un 404
    statusCode = 404
  }

  // escribimos las cabeceras de la respuesta dependiendo de la request
  res.writeHead(statusCode, {'Content-Type': contentType})
  // si tenemos un stream, lo enviamos a la respuesta
  if (stream) stream.pipe(res)
  // si no, devolvemos un string diciendo que no hemos encontrado nada
  else return res.end('Not found')
}

// creamos un servidor con el requestListener
const server = createServer(requestListener)

// hacemos que el servidor escuche el puerto configurado
server.listen(PORT)
