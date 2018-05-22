module.exports = app => {
    const userController = require('../controllers/userController')

    app.route('/users')
        .get(userController.listUsers)
        .post(userController.register)
        .delete(userController.deleteUser)

    app.route('/users/:userId')
        .get(userController.getUser)
}
