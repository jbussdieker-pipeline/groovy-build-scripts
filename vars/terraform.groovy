def getDefaultConfig() {
  return [
    plan: true,
  ]
}

def call(Map config) {
  //def terraform = new Terraform()
  //terraform.run(defaultConfig + config)
}

def call(Closure body) {
  def config = defaultConfig.clone()

  // evaluate the body block, and collect configuration into the object
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()

  call(config)
}
