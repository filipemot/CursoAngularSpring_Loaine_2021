const PROXY_CONFIG = [
  {
    context: ['/api'],
    target: 'http://172.17.112.1:8080/',
    secure: false,
    logLevel: 'debug'
  }
];

module.exports = PROXY_CONFIG;