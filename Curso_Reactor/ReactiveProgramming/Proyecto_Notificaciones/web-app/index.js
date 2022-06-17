import { join } from 'path'
import path from 'path'
import { createReadStream } from 'fs'
import { createServer } from 'http'
import {fileURLToPath} from 'url';

const {PORT = 3000} = process.env

const HTML_CONTENT_TYPE = 'text/html'
const CSS_CONTENT_TYPE = 'text/css'
const JS_CONTENT_TYPE = 'text/javascript'


const __dirname = path.dirname(fileURLToPath(import.meta.url));
const PUBLIC_FOLDER = join(__dirname, 'src/public')

const requestListener = (req, res) => {
  const {url} = req
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