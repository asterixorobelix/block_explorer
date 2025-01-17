# block_explorer

App which lists recent Bitcoin blocks in real time.
When clicking on block information, it shows list of transactions and other relevant information about that block.
Allow user to track any address they want to with a shortcut to that list on the home screen and the balance updates in real time in both USD and BTC.
Tapping on a transaction reveals another component with all addresses involved and total fee paid. 
User can tap on multiple transactions to fetch this data (parallel).
Show list of latest transactions coming into the mempool in real time.

## How it works
The app adheres to recommended [best practices](https://developer.android.com/topic/architecture/recommendations) wherever possible. The app also uses as many first party component libraries as possible, such as ViewModels and Coroutines.

## API
* [MemPool API Documentation](https://mempool.space/docs/api) 
* [Bitfinex API Documentation](https://docs.bitfinex.com/docs)

## Libraries
* Koin
* Ktor
* Mockito
* Truth
* Room

## Improvements
* Better UI
* More extensive unit tests. Add instrumented tests
* CI/CD with Github Actions
* PR template
* Code linting with KtLint or Detekt
* Kotlin Multiplatform Mobile, for an iOS app as well.
* Use Realm for the database instead of Room, so that the app is KMP ready.
