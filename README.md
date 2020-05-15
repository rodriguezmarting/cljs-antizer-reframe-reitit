# Create CLJS app

The main goal of this repository is to facilitate the creation of clojurescript projects.  
Kind of what create-react-app does for React.
  
  
Keep in mind this is an opinionated set of libraries combined based on the author experience/knowledge.  
The full list of libraries can be found in the [Features section](#features).

## Overview

By cloning/forking this project you will get a shadow-cljs project configured.  
The following commands should be enough to start.  
  
    git clone git@github.com:rodriguezmarting/cljs-antizer-reframe-reitit.git
    cd cljs-antizer-reframe-reitit
    npm install
    npm start
  
This will start up the project with live reload for both `CLJS` and `SCSS` files.  
For other scripts refer to [package.json](/package.json).

## Features

`shadow-cljs` Build tool for ClojureScript. Provides access to a REPL and live reloading.

`scss` Scss support with live changes using `node-sass`.

`antizer` ClojureScript library for using Ant Design Components.

`re-frame` Pattern for writing SPAs in ClojureScript, using Reagent.

`reitit` A fast data-driven router for Clojure/Script.

`specs` Specification/types, generative testing. Expound configured for prettier spec errors.

`testing` Test suit configured. Open `localhost:2999` to check it out.

## IDEs

### Vim workflow

#### Using Fireplace:

1.Start the project from the terminal with `npm start`.
1.After starting the project open it with any browser.
1.Open vim and connect to the nREPL server :Connect.
1.Upgrade REPL to a CLJS REPL :Piggieback :app (converts the clojure repl to a clojurescript repl).
1.At this point calls to Eval will work.

#### Using Conjure:

1.Start the project from the terminal with `npm start`.
1.After starting the project open it with any browser.
1.Open vim and connect to the nREPL server :ConjureShadowSelect app.
1.At this point all conjure commands should work.

### Emacs

1.Start the project from the terminal with `npm start`.
1.After starting the project open it with any browser.
1.Open emacs and run `cider-connect-cljs`.
1.It should automatically set the `shadow` REPL and `app` profile. Otherwise, select those manually.
1.At this point the REPL should be up and running.

### VS Code using Calva

1.Install Calva Plugin if you dont have it.
1.Start the project from the terminal with `npm start`.
1.After starting the project open it with any browser.
1.Open VS Code and open the command pallete `ctrl+shift+p`.
1.Run `Connect to a running REPL`.
1.Choose `Shadow-CLJS` and `app` for the REPL and profile.
1.At this point the REPL should be up and running.
