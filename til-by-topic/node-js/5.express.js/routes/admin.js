const path = require('path');
const express = require('express');
const rootDir = require('../util/path');
const router = express.Router();

router.use('/', (req, res, next) => {
    console.log('This always runs!');
    next();
});

router.get('/add-product', (req, res, next) => {
    res.sendFile(path.join(rootDir, 'views', 'add-product.html'));
});

router.post('/add-product', (req, res, next) => {
    console.log(req.body);
    res.redirect('/');
});

module.exports = router;