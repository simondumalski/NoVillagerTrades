# NoVillagerTrades
NoVillagerTrades is a Minecraft plugin that disables trading with villagers.

## Installation
- Downloaded the latest jar from the [releases tab](https://github.com/simondumalski/NoVillagerTrades/releases), and drag it into your `plugins` folder.
- Start the server!
- **(OPTIONAL)** Configure the `config.yml` to your liking and restart the server or run the command `/novillagertrades reload`.
## Usage
### Commands
- `/novillagertrades reload` - Reloads the plugin config.yml.

### Permissions
- `novillagertrades.bypass` - Allows player to bypass the villager trading blocker.

### Configuration
You can modify the messages in the `config.yml` to your liking!

```yaml
# Plugin message
messages:
  # Sent to admins when they reload the config.yml
  reload: '&aSuccessfully reloaded the config.yml!'
  # Sent to players when they try to trade with villagers
  no-trade: '&cVillager trading is disabled at this time!'
  # Players with the permission node 'novillagertrades.bypass' can bypass the villager trading blocker
  # Sent to players when they try to trade with villagers and have the above permission node
  bypass: '&cYou have bypassed the villager trading blocker!'
```  
