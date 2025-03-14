# Laravelista

## Credits

During development of this website these resources were used for inspiration and ideas:

- [Creating Shadow Gradients (So Hot) in both Figma & CSS! - tutorial](https://youtu.be/13nSxfHS7Dwg)
- [CSS Shadow Gradients - generator](https://alvarotrigo.com/shadow-gradients)
- [Fullstack, Full-stack, or Full stack? - grammar](https://grammarhow.com/fullstack-full-stack-or-full-stack/)

The entire website is made with Scala and Tailwind CSS, even the JavaScript code is written using Scala and compiled to JavaScript.


## Quickstart

```bash
pnpm install

# to compile and run once
sbtn run

# or to compile and run on source change
sbtn ~reStart
```

Other useful commands:

```bash
# run this on work start (sbt server)
sbtn

sbtn reStatus

# to format code
scalafmt
```

## Deployment


For docker image:

```bash
# Build and publish to local docker
sbt Docker/publishLocal

# Run local
docker run -p 80:8080 --env-file .env --restart unless-stopped -d ghcr.io/laravelista/laravelista-n6/website:0.1.0-SNAPSHOT

# Build and publish to remote docker repository
sbt Docker/publish

# Run on production
docker run -p 127.0.0.1:8080:8080 --env-file .env --restart unless-stopped -d --name laravelista  ghcr.io/laravelista/laravelista-n6/website:0.1.0-SNAPSHOT

# Run on production (for real)
docker run -p 127.0.0.1:8081:8080 --env-file .env --restart unless-stopped -d --name laravelista  ghcr.io/laravelista/laravelista-n6/website:0.3.0-SNAPSHOT
```

When deploying to production:

1. Login to github container repository
2. Copy .env.example and modify values
3. Run the above command from the directory where `.env` is located in

For zip file:

```
sbt dist
```

Unzip the file and run the binary with `./bin/website`.

## Scala.js

```bash
# development
sbt js/fastLinkJS

# production
sbt js/fullLinkJS
```

## Tailwind CSS

```bash
# watch
pnpm run watch

# production
pnpm run prod
```


## Troubleshooting


### Inspect files in a jar:

```
jar tf .\target\universal\website-0.1.0-SNAPSHOT\lib\eu.laravelista.website-0.1.0-SNAPSHOT.jar
```


### No DRI found for query: ExitCode

According to @armanbilge this is a scala 3 related bug: 

```
sbt:Website> dist
[info] Wrote C:\Users\mario\code\src\github.com\laravelista\laravelista-n6\target\scala-3.2.0\website_3-0.1.0-SNAPSHOT.pom
[info] Main Scala API documentation to C:\Users\mario\code\src\github.com\laravelista\laravelista-n6\target\scala-3.2.0\api...
[info] Skipping unused scalacOptions: -Xsemanticdb, -semanticdb-target
[warn] -- Warning: src\main\scala\eu\laravelista\Main.scala:121:6 ----------------------
[warn] 121 |  def run(args: List[String]): IO[ExitCode] =
[warn]     |      ^le / doc 0s
[warn]     |      No DRI found for query: ExitCode
[warn] one warning found
[info] Main Scala API documentation successful.
[success] All package validations passed
[info] Your package is ready in C:\Users\mario\code\src\github.com\laravelista\laravelista-n6\target\universal\website-0.1.0-SNAPSHOT.zip
[success] Total time: 6 s, completed 22. stu 2022. 20:51:10
```

We have tried adding this dependency but it still did not work:

> add "org.typelevel" %% "cats-effect" % "3.4.1" as a dependency


### Cyclic reference involving object Content

```
exception caught when loading trait Builder: Cyclic reference involving object Content
exception caught when loading module class Content$: Cyclic reference involving object Content
```

Related issue: https://github.com/lampepfl/dotty/issues/15288

