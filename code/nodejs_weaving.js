weaver = new BusinessContextWeaver(registry)

function register(name, email) {
  return new Promise((resolve, reject) => {
    // ...
  })
}

function wrapCall(context, func) {
  return new Promise((resolve, reject) => {
      try {
        weaver.evaluatePreconditions(context)
        resolve()
      } catch (error) {
        reject(error.getMessage())
      }
    })
    .then(_ => func())
    .then(result => {
      context.setOutput(result)
      weaver.applyPostConditions(context)
      return new Promise(
          (resolve, reject) => resolve(context.getOutput())
      )
    })
}

exports.register = (name, email) => {
  const context = new BusinessOperationContext('user.register')
  context.setInputParameter('name', name)
  context.setInputParameter('email', email)
  return wrapCall(context, () => register(name, email))
}
