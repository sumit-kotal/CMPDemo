### Requirements
1. npm - via [Node.js installer](https://nodejs.org/en/download/) or [nvm](https://github.com/nvm-sh/nvm#install--update-script)

### Setup nvm
1. Open terminal
2. Execute `curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash`
3. Execute `nvm install 16`
4. Execute `nvm use 16`
5. Execute `npm install -g mountebank`
6. Execute `npm install -g npm@8.4.1`
7. Execute `npm audit fix`

### Setup the project
1. Locate the current directory in terminal
2. Execute `mb --configfile imposters.ejs`
3. Open `build.gradle` in the current directory
4. Run the project and make sure the app can start correctly

