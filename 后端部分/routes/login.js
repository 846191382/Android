const express = require('express');
const router = express.Router();
const connection = require('../mysql/dbConnection');
const config = require('../config/config');

// 查
router.post('/', (req, res, next) => {
  const resData = JSON.parse(JSON.stringify(config.resJson));
  const {name,pass} = req.body;
  // 定义sql语句
  const sql = `SELECT * FROM android_test WHERE name="123" AND pass="${pass}"`;
  console.log(req.body);
  connection.query(sql, (err, results, fields) => {
    if (err) {
      // 发生错误回传错误提示
      resData.retcode = -1;
      resData.error = err.message;
      res.send(resData);
    } else {
      // 数据返回
      console.log(results);
      resData.obj.list = results;
      res.send(resData);
    }
  });
});
router.post('/add', (req, res, next) => {
  const resData = JSON.parse(JSON.stringify(config.resJson));
  const {name,age,des} = req.body;
  // 定义sql语句
  const sql = `SELECT * FROM android_test WHERE name="${name}" `;
  connection.query(sql, (err, results, fields) => {
    if (err) {
      // 发生错误回传错误提示
      resData.retcode = -1;
      resData.error = err.message;
      res.send(resData);
    } else {
      // 数据返回
      console.log(results);
      resData.obj.list = results;
      res.send(resData);
    }
  });
});
// 改
router.post('/updateList', (req, res, next) => {
  const resData = JSON.parse(JSON.stringify(config.resJson));
  const {name, age } = req.body;
  // 定义sql语句
  const sql = `UPDATE android_test SET name="${name}",age=${age} WHERE id = ${id}`;
  connection.query(sql, (err, results, fields) => {
    if (err) {
      // 发生错误回传错误提示
      resData.retcode = -1;
      resData.error = err.message;
      res.send(resData);
    } else {
      console.log(results);
      if (results.changedRows === 1) {
        // 修改成功
        res.send(resData);
      } else {
        // 修改失败
        resData.retcode = -1;
        res.send(resData);
      }
    }
  });
});

// 增
router.post('/newList', (req, res, next) => {
  const resData = JSON.parse(JSON.stringify(config.resJson));
  const {email,name,pass} = req.body;
  // 定义sql语句
  const sql = `INSERT INTO android_test(email,name,pass) VALUES("${email}","${name}","${pass}");`;
  connection.query(sql, (err, results, fields) => {
    if (err) {
      // 发生错误回传错误提示
      resData.retcode = -1;
      resData.error = err.message;
      res.send(resData);
    } else {
      // 数据返回
      console.log(results);
      if (results.affectedRows === 1) {
        // 插入成功
        res.send(resData);
      } else {
        // 插入失败
        resData.retcode = -1;
        res.send(resData);
      }
    }
  });
});


// 删
router.post('/deleteList', (req, res, next) => {
  const resData = JSON.parse(JSON.stringify(config.resJson));
  const { id } = req.body;
  // 定义sql语句
  const sql = `DELETE FROM android_test WHERE id = ${id}`;
  connection.query(sql, (err, results, fields) => {
    if (err) {
      // 发生错误回传错误提示
      resData.retcode = -1;
      resData.error = err.message;
      res.send(resData);
    } else {
      if (results.affectedRows === 1) {
        // 删除成功
        res.send(resData);
      } else {
        // 删除失败
        resData.retcode = -1;
        res.send(resData);
      }
    }
  });
});

module.exports = router;
